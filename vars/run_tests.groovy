def call(Map opts) {
    stages = [
        stage("Basic tests") {
            steps {
                println "Basic"
            }
        },

        stage("Next step") {
            steps {
                println "Next"
            }
        }
    ]
}
