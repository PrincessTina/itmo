$(document).ready(() => {
    var NoteModel = Backbone.Model.extend({
        urlRoot: 'notes'
    });

    var LegendModel = Backbone.Model.extend({
        urlRoot: 'legends'
    });

    var CharacterModel = Backbone.Model.extend({
        urlRoot: 'characters'
    });

    window.Admin = Backbone.View.extend({
        el: $('body'),

        events: {
            'click .close': 'w3_close',
            'click .open': 'w3_open',
            'click .send_new': 'sendNew',
            'click .send_legend': 'sendLegend',
            'click .send_character': 'sendCharacter',
            'click .gCross': 'closeGNotice',
            'click .bCross': 'closeBNotice',
            'click .clear': 'clear',
            'click .news': 'checkNewsForm',
            'click .legend': 'checkLegendForm',
            'click .character': 'checkCharacterForm',
        },

        initialize() {
            _.bindAll(this, 'render');

            this.render();
            this.checkNewsForm();
        },

        checkNewsForm() {
            document.getElementsByClassName("w3-main")[0].innerHTML = `
                    <div class="w3-container" id="news" style="margin-top:75px">
                        <h1 class="w3-xxxlarge"><b>News</b></h1>
                        <hr style="width:50px;border:5px solid" class="w3-round">
                    </div>
                
                    <div class="w3-container w3-purple">
                        <h2>Input Form</h2>
                    </div>
                
                    <div class="w3-container w3-card-4">
                        <br/>
                        <p>
                            <label class="w3-text-grey">Image link</label>
                            <input class="w3-input w3-border _link" type="text" required="">
                        </p>
                
                        <p>
                            <label class="w3-text-grey">Description <i>(Please, write english)</i></label>
                            <textarea class="w3-input w3-border _description" style="height: 200px;resize:none;"></textarea>
                        </p> <br/>
                
                        <p>
                            <button type="button" class="w3-btn w3-padding w3-purple send_new" style="width:120px">Send &nbsp; ❯</button>
                            <button type="button" class="w3-btn w3-right w3-padding w3-black clear" style="width:120px">Clear</button>
                        </p>
                    </div>
            `;
        },

        checkLegendForm() {
            document.getElementsByClassName("w3-main")[0].innerHTML = `
                    <div class="w3-container" id="news" style="margin-top:75px">
                        <h1 class="w3-xxxlarge"><b>Legend</b></h1>
                        <hr style="width:50px;border:5px solid" class="w3-round">
                    </div>
                
                    <div class="w3-container w3-purple">
                        <h2>Input Form</h2>
                    </div>
                
                    <div class="w3-container w3-card-4">
                        <br/>
                        <p>
                            <label class="w3-text-grey">Name</label>
                            <input class="w3-input w3-border _name" type="text" required="">
                        </p> <br/>
                        <p>
                            <label class="w3-text-grey">Image link</label>
                            <input class="w3-input w3-border _link" type="text" required="">
                        </p> <br/>
                        <p>
                            <label class="w3-text-grey">Country</label>
                            <div>
                                <input class="w3-radio" type="radio" name="country" value="1" checked="">
                                <label>Greece</label>
                                <br/>
                                <input class="w3-radio" type="radio" name="country" value="2">
                                <label>Rome</label>
                                <br/>
                                <input class="w3-radio" type="radio" name="country" value="3">
                                <label>Rus</label>
                                <br/>
                                <input class="w3-radio" type="radio" name="country" value="4">
                                <label>Egypt</label>
                            </div>
                        </p> <br/>
                        <p>
                            <label class="w3-text-grey">Description <i>(Please, write english)</i></label>
                            <textarea class="w3-input w3-border _description" style="height: 200px;resize:none;"></textarea>
                        </p> <br/>
                
                        <p>
                            <button type="button" class="w3-btn w3-padding w3-purple send_legend" style="width:120px">Send &nbsp; ❯</button>
                            <button type="button" class="w3-btn w3-right w3-padding w3-black clear" style="width:120px">Clear</button>
                        </p>
                    </div>
            `;
        },

        checkCharacterForm() {
            document.getElementsByClassName("w3-main")[0].innerHTML = `
                    <div class="w3-container" id="news" style="margin-top:75px">
                        <h1 class="w3-xxxlarge"><b>Character</b></h1>
                        <hr style="width:50px;border:5px solid" class="w3-round">
                    </div>
                
                    <div class="w3-container w3-purple">
                        <h2>Input Form</h2>
                    </div>
                
                    <div class="w3-container w3-card-4">
                        <br/>
                        <p>
                            <label class="w3-text-grey">Name</label>
                            <input class="w3-input w3-border _name" type="text" required="">
                        </p> <br/>
                        <p>
                            <label class="w3-text-grey">Type</label>
                            <input class="w3-input w3-border _type" type="text" required="">
                        </p> <br/>
                        <p>
                            <label class="w3-text-grey">Description <i>(Please, write english)</i></label>
                            <textarea class="w3-input w3-border _description" style="height: 200px;resize:none;"></textarea>
                        </p> <br/>
                
                        <p>
                            <button type="button" class="w3-btn w3-padding w3-purple send_character" style="width:120px">Send &nbsp; ❯</button>
                            <button type="button" class="w3-btn w3-right w3-padding w3-black clear" style="width:120px">Clear</button>
                        </p>
                    </div>
            `;
        },

        sendCharacter() {
            let name = document.getElementsByClassName("_name")[0].value;
            let type = document.getElementsByClassName("_type")[0].value;
            let description = document.getElementsByClassName("_description")[0].value;

            let character = new CharacterModel({
                name: name,
                type: type,
                description: description,
            });

            let result = character.save();

            setTimeout(function () {
                if (result.statusText === "OK") {
                    document.getElementsByClassName("gNotice")[0].style.display = "block";
                } else if (result.statusText === "Internal Server Error") {
                    document.getElementsByClassName("bNotice")[0].style.display = "block";
                }
            }, 200);

            setTimeout(function () {
                document.getElementsByClassName("gNotice")[0].style.display = "none";
            }, 2*1000);
        },

        sendLegend() {
            let name = document.getElementsByClassName("_name")[0].value;
            let link = document.getElementsByClassName("_link")[0].value;
            let description = document.getElementsByClassName("_description")[0].value;
            let country_id;

            document.getElementsByName("country").forEach((element) => {
               if (element.checked) {
                   country_id = element.value;
               }
            });

            let legend = new LegendModel({
                name: name,
                link: link,
                description: description,
                country_id: country_id,
            });

            let result = legend.save();

            setTimeout(function () {
                if (result.statusText === "OK") {
                    document.getElementsByClassName("gNotice")[0].style.display = "block";
                } else if (result.statusText === "Internal Server Error") {
                    document.getElementsByClassName("bNotice")[0].style.display = "block";
                }
            }, 200);

            setTimeout(function () {
                document.getElementsByClassName("gNotice")[0].style.display = "none";
            }, 2*1000);
        },

        sendNew() {
            let link = document.getElementsByClassName("_link")[0];
            let description = document.getElementsByClassName("_description")[0];

            let news = new NoteModel({
                link: link.value,
                description: description.value,
            });

            let result = news.save();

            setTimeout(function () {
                if (result.statusText === "OK") {
                    document.getElementsByClassName("gNotice")[0].style.display = "block";

                    setTimeout(function () {
                        document.getElementsByClassName("gNotice")[0].style.display = "none";
                    }, 2*1000);
                } else if (result.statusText === "Internal Server Error") {
                    document.getElementsByClassName("bNotice")[0].style.display = "block";

                    setTimeout(function () {
                        document.getElementsByClassName("bNotice")[0].style.display = "none";
                    }, 2*1000);
                }
            }, 200);
        },

        clear() {
            let elements = document.getElementsByTagName("input");

            for (let i = 0; i < elements.length; i ++) {
                if (i < 4) {
                    elements[i].value = "";
                }
            }

            document.getElementsByTagName("textarea")[0].value = "";
        },

        closeGNotice() {
            document.getElementsByClassName("gNotice")[0].style.display = "none";
        },

        closeBNotice() {
            document.getElementsByClassName("bNotice")[0].style.display = "none";
        },

        w3_open() {
            document.getElementById("mySidebar").style.display = "block";
            document.getElementById("myOverlay").style.display = "block";
        },

        w3_close() {
            document.getElementById("mySidebar").style.display = "none";
            document.getElementById("myOverlay").style.display = "none";
        },

        render() {
            $(this.el).append(`
                    <!-- Sidebar/menu -->
            <nav class="w3-sidebar w3-purple w3-collapse w3-opacity w3-top w3-large w3-padding"
                 style="z-index: 3; width: 300px; font-weight: bold; display: none;" id="mySidebar"><br>
                <a href="javascript:void(0)" class="close w3-button w3-black w3-hide-large w3-display-topleft"
                   style="width:100%;font-size:22px">Close Menu</a>
            
            
                <div class="w3-bar-block w3-margin">
                    <a href="index.html" class="close w3-border-bottom w3-border-black w3-bar-item w3-button w3-hover-white">Home</a>
                    <a href="#news" class="news close w3-border-bottom w3-border-black w3-bar-item w3-button w3-hover-white">News</a>
                    <a href="#legend" class="legend close w3-border-bottom w3-bar-item w3-button w3-hover-white">Legend</a>
                    <a href="#character" class="character close w3-bar-item w3-button w3-hover-white">Character</a>
                </div>
            </nav>
            
            <!-- Top menu on small screens -->
            <header class="w3-container w3-top w3-hide-large w3-black w3-xlarge w3-padding">
                <a href="javascript:void(0)" class="open w3-button w3-purple w3-margin-right">☰</a>
            </header>
            
            <!-- Overlay effect when opening sidebar on small screens -->
            <div class="close w3-overlay w3-hide-large" style="cursor: pointer; display: none;"
                 title="close side menu" id="myOverlay"></div>
            
            <!-- !PAGE CONTENT! -->
            <div class="w3-main" style="margin-left:340px;margin-right:40px"></div>
            
            <div class="w3-card-4 w3-padding w3-panel w3-green w3-display-container gNotice" style="position: fixed; top: 30%; 
            right: 0; display: none">
              <span class="w3-button w3-green w3-large w3-display-topright gCross">×</span>
              <h3>Success!</h3>
              <p>You have successfully posted new note</p>
            </div>
            
            <div class="w3-card-4 w3-padding w3-panel w3-red w3-display-container bNotice" style="position: fixed; top: 30%; 
            right: 0; display: none">
              <span class="w3-button w3-red w3-large w3-display-topright bCross">×</span>
              <h3>Error :(</h3>
            </div>
        `);
        },
    });
});