def call(Map opts) {
    name = opts.get("name")
    sequence = opts.get("sequence")
    target = opts.get("node")

    run_sequence = node(label: target) {
        sequence.each { seq ->
            stage("Run $seq") {
                def result_file = "results_${seq}.txt"
                sh "echo \$HOSTNAME | tee $result_file"
                echo "Running: $seq"
                sh "env"
                sh "false"

                post {
                    always {
                        println "Stashing ..."
                        stash name: name, includes: "results_*.txt"
                        println "Stashed."
                    }
                }
            }
        }
    }
}
