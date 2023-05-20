package automation.config;

public enum StatusCode {

    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NO_CONTENT(204),
    MOVED_PERMANENTLY(301),
    NOT_MODIFIED(304),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    RECORD_ALREADY_EXIST(409),
    REQUEST_TIMEOUT(408),
    INTERNAL_SERVER_ERROR(500),
    BAD_GATEWAY(502),
    SERVICE_UNAVAILABLE(503),
    GATEWAY_TIMEOUT(504);

    private final int value;

    StatusCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StatusCode getCode(int code) {
        for (StatusCode e : values()) {
            if (e.value == code) {
                return e;
            }
        }
        return OK;
    }
}