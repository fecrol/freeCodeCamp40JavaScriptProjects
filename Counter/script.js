// Buttons
const decreaseBtn = document.getElementById("decrease")
const resetBtn = document.getElementById("reset")
const increaseBtn = document.getElementById("increase")

// Dynamic content
const mainContent = document.getElementById("main-content")

// Functions
const getCurrentNum = (element) => {

    return element.textContent
}

const increaseNum = (num) => {

    return ++num
}

const decreaseNum = (num) => {

    return --num
}

const changeColour = (currentNum) => {

    const positiveCol = "green"
    const negativeCol = "red"
    const neutralCol = "black"

    if(currentNum > 0) {
        return positiveCol
    }
    else if(currentNum < 0) {
        return negativeCol
    }

    return neutralCol
}

// Event Listeners
decreaseBtn.addEventListener("click", () => {

    let currentNum = parseInt(getCurrentNum(mainContent))
    mainContent.textContent = decreaseNum(currentNum)

    currentNum = parseInt(getCurrentNum(mainContent))
    mainContent.style.color = changeColour(currentNum)
})

increaseBtn.addEventListener("click", () => {

    let currentNum = parseInt(getCurrentNum(mainContent))
    mainContent.textContent = increaseNum(currentNum)

    currentNum = parseInt(getCurrentNum(mainContent))
    mainContent.style.color = changeColour(currentNum)
})

resetBtn.addEventListener("click", () => {

    mainContent.textContent = 0
    mainContent.style.color = changeColour(0)
})
