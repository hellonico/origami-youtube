package origami.video;

import com.commit451.youtubeextractor.Stream;
import com.commit451.youtubeextractor.YouTubeExtraction;
import com.commit451.youtubeextractor.YouTubeExtractor;
import origami.Camera;
import origami.Origami;
import origami.filters.MyYolo;

public class YouYubeHVideoHandler implements VideoHandler {
    static {
        Origami.registerVideoHandler("youtube", new YouYubeHVideoHandler());
    }

    private YouTubeExtractor extractor;

    public YouYubeHVideoHandler() {
        extractor = new YouTubeExtractor.Builder().build();
    }

    public String getFilename(String _url) {
        String id = _url.substring(_url.indexOf("://") + 3);
        int index = 0;
        if (id.contains("/")) {
            index = Integer.parseInt(id.substring(id.indexOf("/") + 1));
        }
        YouTubeExtraction yte = extractor.extract(id).blockingGet();
        Stream.VideoStream vs = (Stream.VideoStream) yte.getStreams().get(index);
        String url = vs.getUrl();
        String title = yte.getTitle();
        System.out.printf("Downloading: [%s]", url);

        if (title.contains("/")) {
            title = title.substring(title.lastIndexOf("/") + 1);
        }
        String filename = title + ".mp4";
        new Thread(() -> {
            Origami.asyncTransfer(url, filename);
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
        return filename;
    }

    public static void main(String[] args) throws InterruptedException {
        Origami.init();
        new Camera().device("youtube://FSVTrUIvH8w").filter(new MyYolo.V2()).run();
//        Thread.sleep(Long.MAX_VALUE);
    }

}
