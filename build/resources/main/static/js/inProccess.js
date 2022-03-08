function castShadow() {
    const tractor = document.getElementById('tractor')
    if(tractor != null) {
        const shadow = tractor.cloneNode(true)
        shadow.id = 'shadow'
        tractor.append(shadow)
    }
}

castShadow()