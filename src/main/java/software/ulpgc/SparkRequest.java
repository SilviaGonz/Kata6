package software.ulpgc;

import spark.Request;

public class SparkRequest  implements Input{
    private final Request request;

    public SparkRequest(Request request) {
        this.request = request;
    }

    @Override
    public String getInput(String parameter) {
        return this.request.queryParams(parameter);
    }
}
