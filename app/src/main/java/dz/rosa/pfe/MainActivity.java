package dz.rosa.pfe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    private Python py;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        } else {
            py = Python.getInstance();
            PyObject py_test = py.getModule("python.py_test");
            System.out.println(py_test.repr());
//            PyObject stream = py_test.callAttr("py_class", "Oscar").get("py_return1");
//            System.out.println(stream.toString());
//
//            stream = py_test.get("py_class").callAttr("py_return2");
//            System.out.println(stream.toString());
//
//            stream = py_test.callAttr("py_class", "Chaquopy").callAttr("py_return3");
//            System.out.println(stream.toString());
        }
    }
}
