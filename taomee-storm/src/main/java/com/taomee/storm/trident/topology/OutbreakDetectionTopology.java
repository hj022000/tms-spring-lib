package com.taomee.storm.trident.topology;

import backtype.storm.StormSubmitter;
import com.taomee.storm.trident.filter.DiseaseFilter;
import com.taomee.storm.trident.function.CityAssignment;
import com.taomee.storm.trident.function.DispatchAlert;
import com.taomee.storm.trident.function.HourAssignment;
import com.taomee.storm.trident.function.OutbreakDetector;
import com.taomee.storm.trident.spout.DiagnosisEventSpout;
import com.taomee.storm.trident.state.OutbreakTrendFactory;

import storm.trident.Stream;
import storm.trident.TridentTopology;
import storm.trident.operation.builtin.Count;
import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;
import backtype.storm.tuple.Fields;

/**
 * trident作业
 */
public class OutbreakDetectionTopology {

	public static StormTopology buildTopology() {
		TridentTopology topology = new TridentTopology();
		DiagnosisEventSpout spout = new DiagnosisEventSpout();
		Stream inputStream = topology.newStream("event", spout).name("begin");
		//inputStream.project();
		inputStream
				.each(new Fields("event"), new DiseaseFilter()).name("filter_event")
				.each(new Fields("event"), new CityAssignment(),
						new Fields("city")).name("add_city_field")
				.each(new Fields("event", "city"), new HourAssignment(),
						new Fields("hour", "cityDiseaseHour")).name("add_hour_key")
				.groupBy(new Fields("cityDiseaseHour")).name("aggregate")//实现数据分组聚合
				.persistentAggregate(new OutbreakTrendFactory(), new Count(),
						new Fields("count"))
				.newValuesStream().name("end")
				.each(new Fields("cityDiseaseHour", "count"),
						new OutbreakDetector(), new Fields("alert")).name("add_alert")
				.each(new Fields("alert"), new DispatchAlert(), new Fields()).name("end");
		return topology.build();
	}

	public static void main(String[] args) throws Exception {
		Config conf=new Config();
		/*LocalCluster cluster=new LocalCluster();
		cluster.submitTopology("cdc", conf, buildTopology());*/
		StormSubmitter.submitTopology("abc",conf,buildTopology());
		//Thread.sleep(20000);
		//cluster.shutdown();
	}

}
