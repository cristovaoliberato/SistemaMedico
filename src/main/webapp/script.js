function mostrarCampos() {
    const isDoctorCheckbox = document.getElementById("isDoctorCheckbox");
    const crmField = document.getElementById("crmField");
    const especialidadeField = document.getElementById("especialidadeField");

    if (isDoctorCheckbox.checked) {
        crmField.style.display = "block";
        especialidadeField.style.display = "block";
        crmField.querySelector("input").removeAttribute("disabled");
        especialidadeField.querySelector("input").removeAttribute("disabled");
    } else {
        crmField.style.display = "none";
        especialidadeField.style.display = "none";
        crmField.querySelector("input").setAttribute("disabled", "disabled");
        especialidadeField.querySelector("input").setAttribute("disabled", "disabled");
    }
}


function atualizarCidades() {
    const estadoSelect = document.getElementById("estado");
    const cidadeSelect = document.getElementById("cidade");
    const estadoSelecionado = estadoSelect.value;
    cidadeSelect.innerHTML = "";
    if (estadoSelecionado !== "") {
        fetch(`https://servicodados.ibge.gov.br/api/v1/localidades/estados/${estadoSelecionado}/municipios`)
            .then(response => response.json())
            .then(data => {
                data.forEach(cidade => {
                    const option = document.createElement("option");
                    option.value = cidade.nome;
                    option.textContent = cidade.nome;
                    cidadeSelect.appendChild(option);
                });
            })
            .catch(error => {
                console.log("Ocorreu um erro ao obter as cidades:", error);
            });
    }
}

