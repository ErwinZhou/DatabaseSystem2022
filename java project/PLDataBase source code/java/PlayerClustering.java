import org.py4j.GatewayServer;

public class PlayerClustering {
    private PythonInterface python;

    public PlayerClustering() {
        GatewayServer gatewayServer = new GatewayServer(this);
        gatewayServer.start();
        python = gatewayServer.getPythonServerEntryPoint(new Class[] { PythonInterface.class });
    }

    public int[] clusterPlayers(double[][] playerStats) {
        return python.clusterPlayers(playerStats);
    }

    public static void main(String[] args) {
        PlayerClustering clustering = new PlayerClustering();
        double[][] exampleStats = { {30, 15, 10, 2500, 0.85}, {25, 10, 8, 2000, 0.75} };
        int[] clusters = clustering.clusterPlayers(exampleStats);
        System.out.println("Player Clusters: " + clusters[0] + ", " + clusters[1]);
    }
}
