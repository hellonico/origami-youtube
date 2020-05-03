(defproject origami/video-handlers "0.1.0-SNAPSHOT"
  :java-source-paths ["java"]
  :main origami.video.YouYubeHVideoHandler
  :plugins [[lein-auto "0.1.3"]]
  :auto {:default {:file-pattern #"\.(java)$"}}
  :repositories [["vendredi" "https://repository.hellonico.info/repository/hellonico/"]]
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [origami/origami "4.3.0-1"]])
