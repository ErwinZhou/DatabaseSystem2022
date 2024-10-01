import java.util.List;

public class DecisionSupport {
    private PerformancePredictor predictor;
    private PlayerClustering clustering;

    public DecisionSupport() {
        predictor = new PerformancePredictor();
        clustering = new PlayerClustering();
    }

    public String recommendStrategy(List<Player> players) {
        StringBuilder recommendation = new StringBuilder();

        for (Player player : players) {
            double[] stats = player.getStats();  // 获取球员的统计数据
            double[] performance = predictor.predictPerformance(stats);
            int[] cluster = clustering.clusterPlayers(new double[][]{ stats });

            recommendation.append("Player: ").append(player.getName())
                .append(" - Predicted Performance: ").append(performance[0])
                .append(" - Cluster: ").append(cluster[0])
                .append("\n");
        }

        // 根据分析结果生成策略建议
        recommendation.append("\n建议策略: 根据预测结果和聚类信息，建议加强防守阵容，特别关注集群1中的球员。");

        return recommendation.toString();
    }
}
