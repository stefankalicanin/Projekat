function proveraLozinke() {
        if (document.getElementById('lozinka').value ==
        document.getElementById('potvrdaLozinke').value) {
        document.getElementById('submit').disabled = false;
        } else {
        document.getElementById('submit').disabled = true;
        }
        }