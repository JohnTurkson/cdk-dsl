import software.amazon.awscdk.App

fun main() {
    val app = App()
    ExampleStack(app, "Stack")
    app.synth()
}
