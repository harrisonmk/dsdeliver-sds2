import './styles.css';

import {ReactComponent as YouTubeIcon} from './youtube.svg';
import {ReactComponent as LinkedinIcon} from './linkedin.svg';
import {ReactComponent as InstagramIcon} from './instagram.svg';

function Footer(){

    return (

        <footer className="main-footer">
         App desenvolvido durante a 2ª ed. do evento semana DevSuperior
            <div className="footer-icons">
                <a href="https://www.youtube.com/c/DevSuperior" target="_new">
                 <YouTubeIcon />
                </a>
                <a href="https://www.linkedin.com/in/harrison-mitchell-003275115" target="_new">
                 <LinkedinIcon />
                </a>
                <a href="https://www.instagram.com/harrisonmk10/">
                <InstagramIcon />
                </a>
            </div>
        </footer>

    );


}

export default Footer;