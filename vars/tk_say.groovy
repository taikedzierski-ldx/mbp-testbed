def call(Map args) {
    def text = args.getOrDefault("text", "[not supplied]")
    println "I was told to tell you in turn: ${text}"
}
