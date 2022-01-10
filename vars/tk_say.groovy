def call(Map args) {
    def text = args.getOrDefault("text", "[not supplied]")

    if(args.getOrDefault("shell", false)) {
        sh "echo From shell: $text"
    } else {
        println "I was told to tell you in turn: ${text}"
    }
}
