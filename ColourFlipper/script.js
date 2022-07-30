const colours = ["blue", "red", "yellow", "orange", "green", "purple", "pink"];
const spanElements = [];
let selectedItem = null;

function insertColoursIntoPallet(colourPalletEl, colours) {

    colours.forEach(colour => {
        let spanEl = document.createElement("span");
        spanEl.classList.add("colour");
        spanEl.id = colour + "-span";
        spanEl.style.backgroundColor = colour;
        
        let element = {
            span: spanEl,
            colour: colour
        }
        
        spanElements.push(element);
        colourPalletEl.appendChild(spanEl);
    })
}

function changeBgColour(selectedItem) {

    if(selectedItem !== null) {
        let bgColour = selectedItem.colour;
        document.body.style.backgroundColor = bgColour;
    }
}

document.addEventListener("DOMContentLoaded", () => {
    const colourPalletEl = document.getElementById("colour-pallet");
    const applyBtn = document.getElementById("apply-btn");

    insertColoursIntoPallet(colourPalletEl, colours);

    spanElements.forEach(element => {

        element.span.addEventListener("click", () => {
            
            if(selectedItem !== null) {
                selectedItem.span.classList.remove("selected");
            }
            
            selectedItem = element;
            element.span.classList.add("selected");
        })
    })

    applyBtn.addEventListener("click", () => {

        changeBgColour(selectedItem);
    })

    document.addEventListener("keypress", (e) => {

        if(e.key === "Enter") {
            changeBgColour(selectedItem);
        }
    })
})