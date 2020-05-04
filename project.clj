(defproject origami/youtube "0.1.0"
  :java-source-paths ["java"]
  :main origami.video.YouYubeHVideoHandler
  :plugins [[lein-auto "0.1.3"]]
  :junit ["test-java"]
  :junit-formatter :plain
  :junit-results-dir "target/junit"
  ; :java-source-paths ["java" "test-java"]
  :release-tasks
  [["vcs" "assert-committed"]
  ["change" "version" "leiningen.release/bump-version" "release"]
  ["vcs" "commit"]
  ["vcs" "tag" "--no-sign"]
  ; ["deploy" "vendredi"]
  ["deploy" "clojars"]
  ["change" "version" "leiningen.release/bump-version"]
  ["vcs" "commit"]
  ["vcs" "push"]]
  :auto {:default {:file-pattern #"\.(java)$"}}
  :repositories [["vendredi" "https://repository.hellonico.info/repository/hellonico/"]
  ["jitpack" "https://jitpack.io"]
  ]
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [com.github.Commit451/YouTubeExtractor "6.0.0"]
                 [origami/origami "4.3.0-7" :scope "provided"]])
