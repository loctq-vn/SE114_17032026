package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etIdea;
    private Button btnPost;
    private ListView lvPosts;
    private PostAdapter adapter;
    private List<Post> postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        etIdea = findViewById(R.id.etIdea);
        btnPost = findViewById(R.id.btnPost);
        lvPosts = findViewById(R.id.lvPosts);

        // Khởi tạo danh sách và Adapter
        postList = new ArrayList<>();
        // Thêm dữ liệu mẫu ban đầu
        postList.add(new Post("Alice", "24/03/2026", "This is test content.\nThis is test content.", android.R.drawable.ic_menu_gallery));
        
        adapter = new PostAdapter(this, postList);
        lvPosts.setAdapter(adapter);

        // Xử lý sự kiện khi nhấn nút Post
        btnPost.setOnClickListener(v -> {
            String content = etIdea.getText().toString().trim();
            if (!content.isEmpty()) {
                // Tạo một post mới (sử dụng tên mặc định là Alice và ngày hiện tại giả định)
                Post newPost = new Post("Alice", "24/03/2026", content, android.R.drawable.ic_menu_gallery);
                
                // Thêm vào đầu danh sách
                postList.add(0, newPost);
                
                // Cập nhật ListView
                adapter.notifyDataSetChanged();
                
                // Xóa nội dung trong EditText
                etIdea.setText("");
            }
        });
    }
}
