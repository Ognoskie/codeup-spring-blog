(() => {

    const suppliersAddCoffeeTogglers = document.querySelectorAll(".suppliers-add-coffee-toggler");
    const shopsAddCoffeeTogglers = document.querySelectorAll(".shops-add-coffee-toggler");
    const coffeesMoreInfoTogglers = document.querySelectorAll(".coffee-more-info-toggler");


    const handleToggler = (e) => {
        console.log("Inside toggler");
        new bootstrap.Collapse(e.target.nextElementSibling);
    };

    suppliersAddCoffeeTogglers.forEach(addCoffeeToggler => {
        addCoffeeToggler.addEventListener('click', handleToggler);
    });
    shopsAddCoffeeTogglers.forEach(addCoffeeToggler => {
        addCoffeeToggler.addEventListener('click', handleToggler);
    });
    coffeesMoreInfoTogglers.forEach(moreInfoToggler => {
        moreInfoToggler.addEventListener('click', handleToggler);
    });

})();
