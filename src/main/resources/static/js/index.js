"use strict";

(function() {
const baseURL = "";

axios.get(`${baseURL}/hello`)
    .then(res => { // handle response with callback
        console.log(res);
        console.log("DATA: ", res.data);
    }).catch(err => console.log(err)); // handle error


console.log("Have we got a response yet?");

const getAllOutput = document.querySelector("#getAllOutput");

const marsupialId = document.querySelector("#marsupialId");

const getAllMarsupials = () => {
    axios.get(`${baseURL}/getAllMarsupials`)
    .then(res => {
        const marsupials = res.data;

        getAllOutput.innerHTML = ""; // blanks an element

        marsupials.forEach(marsupial => renderMarsupial(marsupial, getAllOutput));
    }).catch(err => console.log(err));
}

const renderMarsupial = (marsupial) => {   
    const marsupialColumn = document.createElement('div');
    marsupialColumn.classList.add("col");

    const marsupialCard = document.createElement('div');
    marsupialCard.classList.add("card");
    marsupialColumn.appendChild(marsupialCard);

    const newMarsupial = document.createElement('div');
    newMarsupial.classList.add("card-body");
    
    const marsupialName = document.createElement("h3");
    marsupialName.innerText = marsupial.name;
    marsupialName.classList.add("card-title");
    newMarsupial.appendChild(marsupialName);
    marsupialName.addEventListener('click', (e) => updateField(e, marsupial.id));

    const marsupialSpecies = document.createElement("p");
    marsupialSpecies.innerText = `Species: ${marsupial.species}`; 
    marsupialSpecies.classList.add("card-text");
    marsupialSpecies.addEventListener('click', (e) => updateField(e, marsupial.id));
    newMarsupial.appendChild(marsupialSpecies);

    const marsupialColour = document.createElement("p");
    marsupialColour.innerText = `Colour: ${marsupial.colour}`; 
    marsupialColour.classList.add("card-text");
    marsupialColour.addEventListener('click', (e) => updateField(e, marsupial.id));
    newMarsupial.appendChild(marsupialColour);

    const deleteButton = document.createElement('button');
    deleteButton.innerText = "DELETE";
    deleteButton.classList.add("btn", "btn-primary");
    deleteButton.addEventListener('click', () => deleteMarsupial(marsupial.id));

    newMarsupial.appendChild(deleteButton);

    marsupialCard.appendChild(newMarsupial);

    getAllOutput.appendChild(marsupialColumn);
}

const deleteMarsupial = id => {
    axios.delete(`${baseURL}/removeMarsupial/${id}`)
        .then(res => {
            console.log(res);
            getAllMarsupials();
        }).catch(err => console.log(err));
}

const getMarsupialById = () => {
    axios.get(`${baseURL}/getMarsupial/${marsupialId.value}`)
    .then(res => {
        const marsupial = res.data;
        getByIdOutput.innerHTML = "";
        renderMarsupial(marsupial, getByIdOutput);
    }).catch(err => console.log(err));
}

document.querySelector("input#searchName").addEventListener('input', ({target: {value}}) => {
    console.log("SEARCH: ", value);
    if (!value) return getAllMarsupials();
    axios.get(`${baseURL}/getMarsupialByName/${value}`)
        .then(({data}) => {
            getAllOutput.innerHTML = "";
            console.log("DATA: ", data);    
            data.forEach(marsupial => renderMarsupial(marsupial));
        }).catch(err => console.log(err));
});

document.querySelector("section#postSection > form").addEventListener('submit', (event) => {
    event.preventDefault(); // stops the form submitting in the default way

    const form = event.target;

    const data = {
        name: form.name.value,
        species: form.species.value,
        colour: form.colour.value,
    }

    console.log("DATA: ", data);

    axios.post(`${baseURL}/createMarsupial`, data)
    .then((res) => {
        console.log(res);
        getAllMarsupials();

        form.reset(); //resets form
        form.name.focus(); // selects the name input
    }).catch(err => console.log(err));
});

const updateField = ({target}, id) => {
    const replaceInput = document.createElement('input');
    replaceInput.classList.add("form-control");
    const placeholder = target.tagName === "H3" ? "Name" :  target.innerText.split(":")[0];
    replaceInput.placeholder = placeholder;

    replaceInput.addEventListener('keyup', async (event) => {
        event.preventDefault();
        if (event.key === "Enter")  {
            try {
                const res = await axios.patch(`${baseURL}/patchMarsupial/${id}?${placeholder.toLowerCase()}=${event.target.value}`);
                getAllMarsupials();
            } catch(err) {
                console.error(err);
            }
        } else if (event.key === "Escape") return getAllMarsupials();
    });
    target.replaceWith(replaceInput);
    replaceInput.focus();
}

getAllMarsupials();

})();