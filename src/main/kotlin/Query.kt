package cholwell.dev.ktor_query

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
