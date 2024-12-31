package apache.flink;

import java.util.Arrays;

public class BatchDemo {
//    public static void main(String[] args) throws Exception {
//      // 1.创建执行环境
//      StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//
//      // 2.读取数据源
//      DataStream<String> textStream =
//          env.fromCollection(
//              Arrays.asList("java,c++,php,java,spring", "hadoop,scala", "c++,jvm,html,php"));
//
//      // 3.数据转换
//      DataStream<Tuple2<String, Integer>> wordCountStream =
//          textStream
//              // 对数据源的单词进行拆分，每个单词记为1，然后通过out.collect将数据发射到下游算子
//              .flatMap(
//                  new FlatMapFunction<String, Tuple2<String, Integer>>() {
//                    @Override
//                    public void flatMap(String s, Collector<Tuple2<String, Integer>> collector)
//                        throws Exception {
//                      for (String word : s.split(",")) {
//                        collector.collect(new Tuple2<>(word, 1));
//                      }
//                    }
//                  })
//              .keyBy(value -> value._1)
//              // 对某个组里的单词的数量进行滚动相加统计
//              .reduce((a, b) -> new Tuple2<>(a._1, a._2 + b._2));
//
//      // 4. 数据输出。字节输出到控制台
//      wordCountStream.print("WordCountBatch========").setParallelism(1);
//      // 5.启动任务
//      env.execute(BatchDemo.class.getSimpleName());
    }
}
