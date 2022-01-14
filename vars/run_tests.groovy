def call(Map opts) {
    name = opts.get("name")
    sequence = opts.get("sequence")
    target = opts.get("node")

    run_sequence = node(label: target) {
        sequence.each { seq ->
            stage("Run $seq") {
                echo "Running: $seq"
                sh "env"
            }
        }
    }
}
