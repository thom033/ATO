const inputs = document.querySelectorAll('.input-group .input');
const labels = document.querySelectorAll('.input-group .user-label');

function checkValue(){
    for(let i=0;i<inputs.length;i++){
        if(inputs[i].value==""){
            down(inputs[i],labels[i]);
        }
        else{
            up(inputs[i],labels[i]);
        }
    }
}

for(let i=0;i<inputs.length;i++){
    // Écouteur d'événement pour les changements manuels
    inputs[i].addEventListener('input', checkValue);

    // MutationObserver pour les changements de valeur par JavaScript
    const observer = new MutationObserver(() => {
      checkValue();
    });

    // Configuration de l'observateur pour surveiller les attributs
    observer.observe(inputs[i], { attributes: true, attributeFilter: ['value'] });
}

function up(input,label){
    label.style.transform="translateY(-40%) scale(0.8)";
    label.style.backgroundColor="#fff";
    label.style.padding="0.2rem";
    label.style.color="#82b6fb";
    label.style.margin.top="1px";
    input.style.border="1.5px solid #82b6fb";
}

function down(input,label){
    label.style.transform="";
    label.style.backgroundColor="transparent";
    label.style.padding="";
    label.style.color="#000";
    label.style.margin.top="";
    input.style.border="1.5px solid #000";
}