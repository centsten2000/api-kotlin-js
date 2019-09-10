data class ApiGatewayResponse(val statusCode: Int = 200, val body: String, val headers: dynamic)
class Response(val message: String, val input: dynamic) {
    override fun toString() = "{\"$message\": ${js("JSON.stringify(this.input)")} }"
}

@JsName("handler")
fun handler(input: dynamic = {}, context: Any, callback: (Any?, ApiGatewayResponse) -> ApiGatewayResponse): Any {
    println("Received: " + js("JSON.stringify(input)"))

    val headers: dynamic = object {}
    headers["X-Powered-By"] = "AWS Lambda & serverless"

    return callback(null, ApiGatewayResponse(
            statusCode = 201,
            body = Response("Go Serverless v1.x! Your Kotlin function executed successfully!", input).toString(),
            headers = headers
    ))
}
