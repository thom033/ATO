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