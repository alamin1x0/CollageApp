package com.example.dpi.navigation.ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.dpi.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;

import java.io.File;

import es.dmoral.toasty.Toasty;

public class PdfViewerActivity extends AppCompatActivity {

    private String url;
    private PDFView pdfView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        url = getIntent().getStringExtra("pdfUrl");

        pdfView = findViewById(R.id.pdfView);

        //start progressBar
        progressBar = findViewById(R.id.pdfProgress);

        loadFile(url);



//        new PdfDownload().execute(url);
//    }

//    private class PdfDownload extends AsyncTask<String, Void, InputStream>{
//
//        @Override
//        protected InputStream doInBackground(String... strings) {
//            InputStream inputStream = null;
//
//            try {
//                URL url = new URL(strings[0]);
//                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//
//                if (urlConnection.getResponseCode() == 200){
//                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return inputStream;
//        }
//
//        @Override
//        protected void onPostExecute(InputStream inputStream) {
//            pdfView.fromStream(inputStream).load();
//        }
//    }

    }

    private void loadFile(String url) {

        FileLoader.with(this)
                .load(url)
                .fromDirectory("test4", FileLoader.DIR_INTERNAL)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest request, FileResponse<File> response) {
                        File loadedFile = response.getBody();
                        progressBar.setVisibility(View.GONE);
                        pdfView.fromFile(loadedFile)
                                .password(null)
                                .defaultPage(0)
                                .enableSwipe(true)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .spacing(5)
                                .load();
                    }

                    @Override
                    public void onError(FileLoadRequest request, Throwable t) {
                        Toasty.error(PdfViewerActivity.this, "Error"+ t.getMessage(),Toasty.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });

    }
}