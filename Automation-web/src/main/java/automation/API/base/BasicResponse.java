package automation.API.base;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BasicResponse extends BaseResponse<BasicResponse> {

    public int code;
    public String status;

    @Override
    public BasicResponse getBody() {
        return this;
    }

    public static BasicResponse toModel(String json) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();
        return gson.fromJson(json, BasicResponse.class);
    }
}