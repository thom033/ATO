function uploadImage() {
    var formData = new FormData();
    var fileInput = document.getElementById('fileInput');
    var file = fileInput.files[0];
    formData.append('file', file);

    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/upload/profil', true);

    xhr.onload = function () {
        if (xhr.status === 200) {
            alert('Image uploaded successfully!');
            location.reload();  // Reload the page
        } else {
            alert('Image upload failed!');
        }
    };

    xhr.send(formData);
}
function uploadImagePoste(idPoste) {
    var formData = new FormData();
    var fileInput = document.getElementById('fileInput');
    var file = fileInput.files[0];
    formData.append('file', file);

    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/upload/poste/' + idPoste, true);  // Use the idPoste in the URL

    xhr.onload = function () {
        if (xhr.status === 200) {
            alert('Image uploaded successfully!');
            location.reload();  // Reload the page
        } else {
            alert('Image upload failed!');
        }
    };

    xhr.send(formData);
}
