import org.py4j.GatewayServer;

public class PerformancePredictor {
    private PythonInterface python;

    public PerformancePredictor() {
        GatewayServer gatewayServer = new GatewayServer(this);
        gatewayServer.start();
        python = gatewayServer.getPythonServerEntryPoint(new Class[] { PythonInterface.class });
    }

    public double[] predictPerformance(double[] playerStats) {
        return python.predictPerformance(playerStats);
    }

    public static void main(String[] args) {
        PerformancePredictor predictor = new PerformancePredictor();
        double[] exampleStats = { 30, 15, 10, 2500, 0.85 };
        double[] predictions = predictor.predictPerformance(exampleStats);
        System.out.println("Predicted Performance: " + predictions[0]);
    }
}
