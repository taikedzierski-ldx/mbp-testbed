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
                                check_content name: "content_1"
                            }
                        } // stage, step

                        stage("Run parallel 2") {
                            steps {
                                check_content name: "content_2"
                            }
                        } // stage, step
                    }
                } // stage Clone Repo
            } // inner stages
        } // stage OVerall
    } // stages
} // pipeline
