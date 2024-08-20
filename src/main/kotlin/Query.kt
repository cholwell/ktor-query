package cholwell.dev.ktor_query

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod
import io.ktor.server.routing.Route
import io.ktor.server.routing.RoutingHandler
import io.ktor.server.routing.route
import io.ktor.utils.io.KtorDsl

val HttpMethod.Companion.Query get() = HttpMethod("QUERY")

@KtorDsl
fun Route.query(path: String, body: RoutingHandler): Route {
    return route(path, HttpMethod.Query) { handle(body) }
}

suspend inline fun HttpClient.query(url: String, block: HttpRequestBuilder.() -> Unit): HttpResponse {
    return request { method = HttpMethod.Query; url(url); block() }
}
