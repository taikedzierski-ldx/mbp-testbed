def call(Map opts) {
    name = opts.get("name")
    sequence = opts.get("sequence")
    target = opts.get("node")

    run_sequence = node(label: target) {
        sequence.each { seq ->
            stage("Run $seq") {
                catchError() {
                    def result_file = "${seq}_file.txt"
                    sh "echo \$HOSTNAME | tee $result_file"
                    echo "Running: $seq"
                    sh "env"
                    sh "false"
                }

                stash name: seq, includes: result_file
            }
        }
    }
}
