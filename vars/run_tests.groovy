def call(Map opts) {
    def name = opts.get("name")
    def sequence = opts.get("sequence")
    def target = opts.get("node")

    run_sequence = node(label: target) {
        sequence.each { seq ->
            stage("Run $seq") {
                def success = false
                catchError(stageResult: "FAILURE") {
                    def result_file = "results_${seq}.txt"
                    echo "Running: $seq"
                    sh "(echo \$HOSTNAME ; env)| tee $result_file"
                    sh "false"

                    success = true
                }

                println "Stashing ..."
                stash name: name, includes: "results_*.txt"
                println "Stashed."

                if(! success) {
                    sh "false" // this one is not caught
                }
            }
        }
    }
}
