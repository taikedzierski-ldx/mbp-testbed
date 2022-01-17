PROJECT_REPO='https://github.com/taikedzierski-ldx/mbp-testbed'

library identifier: "commonlib@${CHANGE_BRANCH}",
    retriever: modernSCM([
      $class: 'GitSCMSource',
      remote: PROJECT_REPO
])

pipeline {


    options {
        // If a job in a parallel area fails, fail all other parallel branches immediately
        parallelsAlwaysFailFast()

        // During an `agent` directive, a full repo checkout can be performed.
        // This step prevents that from happening as we want to control the checkout location
        skipDefaultCheckout()
    }
    agent { label "_runner:linux" }

    stages {
        stage("Overall") {
            agent { label "_runner:linux" }

            stages {
                stage("Parallelised") {
                    parallel {
                        stage("Run parallel 1") {
                            steps {
                                run_tests name: "parallel_1", sequence: ["a", "b"], target: "_ldx2_"
                            }
                        } // stage, step

                        stage("Run parallel 2") {
                            steps {
                                run_tests name: "parallel_2", sequence: ["c", "d"], target: "_ldx2_"

                            }
                        } // stage, step
                    }

                    post {
                        always {
                            unstash name: "parallel_1"
                            unstash name: "parallel_2"
                            sh "hostname; pwd; ls"
                        }
                    }
                } // stage Clone Repo
            } // inner stages
        } // stage OVerall
    } // stages
} // pipeline
