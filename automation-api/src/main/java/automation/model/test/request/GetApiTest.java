package automation.model.test.request;
import automation.model.base.BaseRequest;

public class GetApiTest extends BaseRequest<GetApiTest>{

public String params;

@Override
public GetApiTest getBody() {
        return this;
        }

public GetApiTest() {params = "";}
}

