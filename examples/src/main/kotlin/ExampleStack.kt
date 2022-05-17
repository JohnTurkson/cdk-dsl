import software.amazon.awscdk.Stack
import software.amazon.awscdk.StackProps
import software.amazon.awscdk.services.s3.Bucket
import software.constructs.Construct

class ExampleStack(parent: Construct, name: String, props: StackProps? = null) : Stack(parent, name, props) {
    init {
        Bucket.Builder.create(this, "ExampleBucket").build()
    }
}
