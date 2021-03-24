(ns twt-filtered-stream.api
  (:require [cheshire.core :refer :all]
            [clj-http.client :as http]))

(def bearer-token "AAAAAAAAAAAAAAAAAAAAAAqnNwEAAAAAg4OueGO7OyaTj1YTPcCzWSiXmcg%3DATT5PL92nIncuePAP9UBXDriqcCfy6xfjVTkqjwy75dQnYVrNp"
         ;(System/getenv "BEARER_TOKEN_K") ;to be changed to use env
         )

(defn post-rule
  "makes POST stream rule modification request"
  [& {:as body}]
  (let [url "https://api.twitter.com/2/tweets/search/stream/rules"]
    (http/post url
               {:oauth-token bearer-token
                :headers        {"Content-Type" "application/json"}
                :body           (generate-string body)
                :cookie-policy  :standard
                :decode-cookies false
                :debug?           true
                :debug-body       true
                :throw-exceptions false
                })))


(defn get-rule
  "make GET current stream rule list request"
  [& {:as body}]
  (let [url "https://api.twitter.com/2/tweets/search/stream/rules"]
    (http/get url
               {:oauth-token bearer-token
                :cookie-policy  :standard
                :decode-cookies false
                :debug?           true
                :debug-body       true
                :throw-exceptions false})))

(defn get-stream
  "make GET filtered stream request"
  [& {:as body}]
  (let [url "https://api.twitter.com/2/tweets/search/stream"]
    (http/get url
              {:oauth-token bearer-token
               :cookie-policy  :standard
               :decode-cookies false
               :debug?           true
               :debug-body       true
               :throw-exceptions false})))

;using just get request returns error


(comment

  (post-rule :add [{:value "from:FoxNews"}])
  (get-rule)
  )
