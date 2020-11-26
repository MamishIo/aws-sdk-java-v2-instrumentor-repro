package io.mamish.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.services.sts.StsClient;

public class LambdaHandler implements RequestHandler<String,String> {

    @Override
    public String handleRequest(String event, Context context) {
        // Sample code to do some dummy API call (sts:GetCallerIdentity)
        StsClient stsClient = StsClient.create();
        String arn = stsClient.getCallerIdentity().arn();
        context.getLogger().log(arn);
        return arn;
    }

}
