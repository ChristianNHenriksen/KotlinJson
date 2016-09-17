/**
 * Created by Christian on 17/09/2016.
 */

fun main(args: Array<String>) {
    val jsonString = "{ \"name\": \"Peter\", \"age\": 35, \"animals\": [ \"Dog\", \"Cat\" ], \"address\": { \"street\": \"street\", \"city\": \"city\", \"location\": { \"latitude\": 10, \"longitude\": 20 } } }"

    val json = JsonParser.parse(jsonString).jsonObject ?: return
    println("Name: ${json["name"].string}")
    println("Age: ${json["age"].int}")

    val animals = json["animals"].array ?: return
    println("Animals:")
    animals.forEach { println("${it.string}") }

    val address = json["address"].jsonObject ?: return
    println("Street: ${address["street"].string}")
    println("City: ${address["city"].string}")

    println("Location:")
    val latitude = json["address"]["location"]["latitude"].int
    println("Latitude: ${latitude}")
    val longitude = json["address"]["location"]["longitude"].int
    println("Longitude: ${longitude}")
}