def call(Map opts) {
    name = opts.get("name")
    println "Running with name $name"
    node(label: "_runner:linux") {
        stage("Running $name") {
            println "In-stage : $name"
        }
    }
}
