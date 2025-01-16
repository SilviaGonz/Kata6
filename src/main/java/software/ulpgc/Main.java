package software.ulpgc;

import spark.Spark;

public class Main {
    public static void main(String[] args) {
        CommandFactory commandFactory = new CommandFactory();
        commandFactory.register("/taskdays", CalculateDaysCommand::new);
        Spark.port(8080);
        Spark.get("/taskdays", (request, response) -> {
            Command command = commandFactory.get(request.pathInfo(), new SparkRequest(request), new SparkResponse(response));
            command.execute();
            response.status(200);
            response.type("application/json");
            return response.body();

        });
    }
}
