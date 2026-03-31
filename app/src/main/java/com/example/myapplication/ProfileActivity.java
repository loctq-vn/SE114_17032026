package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvHeaderName;
    private ImageView ivAvatar;
    private EditText etProfileName, etProfileEmail, etProfileAddress, etProfileAvatarUrl, etProfileDescription;
    private Button btnSave, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Ánh xạ View
        tvHeaderName = findViewById(R.id.tvHeaderName);
        ivAvatar = findViewById(R.id.ivAvatar);
        etProfileName = findViewById(R.id.etProfileName);
        etProfileEmail = findViewById(R.id.etProfileEmail);
        etProfileAddress = findViewById(R.id.etProfileAddress);
        etProfileAvatarUrl = findViewById(R.id.etProfileAvatarUrl);
        etProfileDescription = findViewById(R.id.etProfileDescription);
        btnSave = findViewById(R.id.btnSave);
        btnLogout = findViewById(R.id.btnLogout);

        // Load dữ liệu mẫu (Thực tế sẽ load từ Database/API)
        loadProfileData();

        // Xử lý nút Save
        btnSave.setOnClickListener(v -> {
            String newName = etProfileName.getText().toString().trim();
            // Lưu dữ liệu vào DB...
            tvHeaderName.setText(newName + "!");
            Toast.makeText(ProfileActivity.this, "Đã lưu thông tin", Toast.LENGTH_SHORT).show();
        });

        // Xử lý nút Logout
        btnLogout.setOnClickListener(v -> {
            // Xóa session/token ở đây
            Toast.makeText(ProfileActivity.this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
            // Điều hướng về Login hoặc Main tùy logic của bạn
            finish();
        });
    }

    private void loadProfileData() {
        // Hàm này giả lập việc lấy dữ liệu người dùng đổ vào View
        tvHeaderName.setText("Alice!");
        etProfileName.setText("Alice");
        etProfileEmail.setText("test@mail.com");
        // Có thể dùng thư viện Glide hoặc Picasso để load URL ảnh vào ivAvatar
    }
}