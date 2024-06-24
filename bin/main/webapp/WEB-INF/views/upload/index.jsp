<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Upload Image</title>
</head>
<body>
    <form id="uploadForm" enctype="multipart/form-data">
        <input type="file" id="fileInput" name="file" accept="image/*">
        <button type="button" onclick="uploadImage()">Upload</button>
    </form>

    <script>
        function uploadImage() {
            var formData = new FormData();
            var fileInput = document.getElementById('fileInput');
            var file = fileInput.files[0];
            formData.append('file', file);

            var xhr = new XMLHttpRequest();
            xhr.open('POST', '/upload', true);

            xhr.onload = function () {
                if (xhr.status === 200) {
                    alert('Image uploaded successfully!');
                } else {
                    alert('Image upload failed!');
                }
            };

            xhr.send(formData);
        }
    </script>
</body>
</html>
