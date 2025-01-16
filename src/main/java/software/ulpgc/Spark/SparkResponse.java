package software.ulpgc.Spark;

import software.ulpgc.io.Output;
import spark.Response;

public class SparkResponse implements Output {
    private final Response response;

    public SparkResponse(Response response) {
        this.response = response;
    }

    @Override
    public void setOutput(String output) {
        this.response.body(output);
    }
}
