pipeline {
    agent none

    parameters {
        string(name: "TEST_AGENT_LABEL", defaultValue: "_invalid_")
    }

    stages {
        stage {
            agent { label params.TEST_AGENT_LABEL }

            steps {
                println "Running on ${TEST_AGENT_LABEL}"
            }
        }
    }
}
