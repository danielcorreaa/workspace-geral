package mk;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class Kitana implements Runnable	{
	 private BufferedImage bufferImg = null;
	    private Thread tempo;
	    private int x;
	    private boolean continuar;
	    private boolean pararo;
	    private boolean soco;
	    private boolean chute;
	    private boolean socobaixo;
	    private boolean chuteBaixo;
	    private boolean apresentacao;
	    private boolean voadora;
	    private boolean rasteira;
	    private boolean uper;
	    private boolean andar;
	    private boolean pular;
	    private boolean bloquear;
	    private boolean abaixar;
	    private boolean bloquearAbaixar;
	    private EfeitosSonoros efeito;

	    public Kitana() {
	        continuar = true;
	        lerImagem();
	        tempo = new Thread(this);
	        correrTempo();
	        iniciarGolpes();
	        x = 100;
	    }

	    public BufferedImage getBufferImg() {
	        return bufferImg;
	    }

	    public void setBufferImg(BufferedImage bufferImg) {
	        this.bufferImg = bufferImg;
	    }

	    public Thread getTempo() {
	        return tempo;
	    }

	    public void setTempo(Thread tempo) {
	        this.tempo = tempo;
	    }

	    public boolean isContinuar() {
	        return continuar;
	    }

	    public void setContinuar(boolean continuar) {
	        this.continuar = continuar;
	    }

	    public boolean isPararo() {
	        return pararo;
	    }

	    public void setPararo(boolean pararo) {
	        this.pararo = pararo;
	    }

	    public boolean isSoco() {
	        return soco;
	    }

	    public void setSoco(boolean soco) {
	        this.soco = soco;
	    }

	    public boolean isChute() {
	        return chute;
	    }

	    public void setChute(boolean chute) {
	        this.chute = chute;
	    }

	    public boolean isSocobaixo() {
	        return socobaixo;
	    }

	    public void setSocobaixo(boolean socobaixo) {
	        this.socobaixo = socobaixo;
	    }

	    public boolean isChuteBaixo() {
	        return chuteBaixo;
	    }

	    public void setChuteBaixo(boolean chuteBaixo) {
	        this.chuteBaixo = chuteBaixo;
	    }

	    public boolean isApresentacao() {
	        return apresentacao;
	    }

	    public void setApresentacao(boolean apresentacao) {
	        this.apresentacao = apresentacao;
	    }

	    public boolean isVoadora() {
	        return voadora;
	    }

	    public void setVoadora(boolean voadora) {
	        this.voadora = voadora;
	    }

	    public boolean isRasteira() {
	        return rasteira;
	    }

	    public void setRasteira(boolean rasteira) {
	        this.rasteira = rasteira;
	    }

	    public boolean isUper() {
	        return uper;
	    }

	    public void setUper(boolean uper) {
	        this.uper = uper;
	    }

	    public boolean isAndar() {
	        return andar;
	    }

	    public void setAndar(boolean andar) {
	        this.andar = andar;
	    }

	    public boolean isPular() {
	        return pular;
	    }

	    public void setPular(boolean pular) {
	        this.pular = pular;
	    }

	    public int getX() {
	        return x;
	    }

	    public void setX(int x) {
	        this.x = x;
	    }

	    public boolean isBloquear() {
	        return bloquear;
	    }

	    public void setBloquear(boolean bloquear) {
	        this.bloquear = bloquear;
	    }

	    public boolean isAbaixar() {
	        return abaixar;
	    }

	    public void setAbaixar(boolean abaixar) {
	        this.abaixar = abaixar;
	    }

	    public boolean isBloquearAbaixar() {
	        return bloquearAbaixar;
	    }

	    public void setBloquearAbaixar(boolean bloquearAbaixar) {
	        this.bloquearAbaixar = bloquearAbaixar;
	    }

	    public EfeitosSonoros getEfeito() {
	        return efeito;
	    }

	    public void setEfeito(EfeitosSonoros efeito) {
	        this.efeito = efeito;
	    }

	    public BufferedImage lerImagem() {
	        try {

	            bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));

	        } catch (IOException ex) {
	            Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        bufferImg = bufferImg.getSubimage(67, 0, 44, 120);
	        return bufferImg;
	    }

	    @Override
	    public void run() {
	        try {
	            while (continuar) {
	                try {

	                    bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));

	                } catch (IOException ex) {
	                    Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                }
	                bufferImg = bufferImg.getSubimage(67, 0, 44, 120);
	                if (pararo) {
	                    for (int i = 67; i < 244; i += 44) {
	                        Thread.sleep(100);
	                        try {
	                            bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));

	                        } catch (IOException ex) {
	                            Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                        }
	                        bufferImg = bufferImg.getSubimage(i, 0, 44, 120);

	                    }
	                } else if (andar) {
	                    for (int i = 11; i < 215; i += 42) {

	                        Thread.sleep(100);
	                        try {
	                            bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                        } catch (IOException ex) {
	                            Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                        }
	                        bufferImg = bufferImg.getSubimage(i, 128, 42, 120);

	                    }
	                } else if (soco) {
	                    while (soco) {
	                        Thread.sleep(100);
	                        try {
	                            bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                        } catch (IOException ex) {
	                            Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                        }
	                        bufferImg = bufferImg.getSubimage(0, 377, 60, 113);
	                        efeito = new EfeitosSonoros();
	                        efeito.TocaAudio("lib//som//124.wav");

	                        Thread.sleep(100);
	                        try {
	                            bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                        } catch (IOException ex) {
	                            Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                        }
	                        bufferImg = bufferImg.getSubimage(61, 377, 60, 113);
	                        efeito = new EfeitosSonoros();
	                        efeito.TocaAudio("lib//som//124.wav");

	                        Thread.sleep(100);
	                        try {
	                            bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                        } catch (IOException ex) {
	                            Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                        }
	                        bufferImg = bufferImg.getSubimage(123, 377, 77, 113);
	                        efeito = new EfeitosSonoros();
	                        efeito.TocaAudio("lib//som//124.wav");

	                        Thread.sleep(100);
	                        try {
	                            bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                        } catch (IOException ex) {
	                            Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                        }
	                        bufferImg = bufferImg.getSubimage(199, 377, 77, 113);
	                        efeito = new EfeitosSonoros();
	                        efeito.TocaAudio("lib//som//124.wav");

	                        Thread.sleep(100);
	                        try {
	                            bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                        } catch (IOException ex) {
	                            Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                        }
	                        bufferImg = bufferImg.getSubimage(343, 377, 76, 113);
	                        efeito = new EfeitosSonoros();
	                        efeito.TocaAudio("lib//som//124.wav");

	                        Thread.sleep(100);
	                        try {
	                            bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                        } catch (IOException ex) {
	                            Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                        }
	                        bufferImg = bufferImg.getSubimage(276, 377, 67, 113);
	                        efeito = new EfeitosSonoros();
	                        efeito.TocaAudio("lib//som//124.wav");

	                    }
	                } else if (bloquear) {
	                    while (bloquear) {
	                        for (int i = 295; i < 336; i += 46) {
	                            Thread.sleep(100);
	                            try {
	                                bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));

	                            } catch (IOException ex) {
	                                Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                            }
	                            bufferImg = bufferImg.getSubimage(i, 0, 46, 120);

	                        }
	                    }

	                } else if (abaixar) {
	                    Thread.sleep(100);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));

	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(476, 0, 46, 120);
	                    for (;;) {
	                        Thread.sleep(100);
	                        try {
	                            bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));

	                        } catch (IOException ex) {
	                            Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                        }
	                        bufferImg = bufferImg.getSubimage(522, 0, 46, 120);
	                        if (abaixar == false) {
	                            break;
	                        }
	                    }
	                } else if (bloquearAbaixar) {

	                    Thread.sleep(100);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));

	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(574, 0, 46, 120);
	                    while (bloquearAbaixar) {
	                        Thread.sleep(100);
	                        try {
	                            bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));

	                        } catch (IOException ex) {
	                            Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                        }
	                        bufferImg = bufferImg.getSubimage(620, 0, 46, 120);
	                        if (bloquearAbaixar == false) {
	                            break;
	                        }

	                    }

	                } else if (apresentacao) {
	                    Thread.sleep(200);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(13, 245, 25, 142);

	                    Thread.sleep(200);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(46, 245, 47, 142);

	                    Thread.sleep(200);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(99, 245, 49, 142);

	                    Thread.sleep(200);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(156, 245, 55, 142);

	                    Thread.sleep(200);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(218, 245, 85, 142);

	                    Thread.sleep(200);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(309, 245, 92, 142);

	                    Thread.sleep(200);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(409, 245, 89, 142);

	                    Thread.sleep(200);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(503, 245, 70, 142);

	                    Thread.sleep(200);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(572, 245, 52, 142);

	                    Thread.sleep(200);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(623, 245, 45, 142);

	                    Thread.sleep(200);
	                    try {
	                        bufferImg = ImageIO.read(new File("lib\\personagem\\kitana.png"));
	                    } catch (IOException ex) {
	                        Logger.getLogger(Kitana.class.getName()).log(Level.SEVERE, null, ex);
	                    }
	                    bufferImg = bufferImg.getSubimage(667, 245, 47, 142);

	                }

	            }
	        } catch (Exception ex) {

	        }
	    }

	    private void correrTempo() {
	        tempo.start();
	    }

	    private void iniciarGolpes() {
	        pararo = true;
	        chute = false;
	        soco = false;
	        socobaixo = false;
	        chuteBaixo = false;
	        rasteira = false;
	        voadora = false;
	        apresentacao = false;
	        uper = false;
	        pular = false;
	        andar = false;
	        bloquear = false;
	        abaixar = false;
	        bloquearAbaixar = false;

	    }

	    public void andar() {
	        x++;
	        if (x > 568) {
	            x = 0;
	        }
	    }

	    public void keyPressed(KeyEvent tecla) {
	        int codigo = tecla.getKeyCode();
	        int codigo2 = tecla.getKeyCode();

	        if (codigo == tecla.VK_RIGHT) {
	            andar = true;
	            pararo = false;
	            andar();
	        }
	        if (codigo == tecla.VK_SPACE) {
	            soco = true;
	            pararo = false;
	            andar = false;

	        }
	        if (codigo == tecla.VK_Y) {
	            chute = true;
	        }
	        if (codigo == tecla.VK_L) {
	            soco = false;
	            pararo = false;
	            andar = false;
	            bloquear = true;
	        }
	        if (codigo == tecla.VK_DOWN) {
	            pararo = false;
	            abaixar = true;

	        }
	        if (codigo2 == tecla.VK_F) {
	            pararo = false;
	            bloquearAbaixar = true;

	        }
	        if (codigo == tecla.VK_ENTER) {
	            pararo = false;
	            apresentacao = true;

	        }

	    }

	    public void keyReleased(KeyEvent tecla) {
	        int codigo = tecla.getKeyCode();
	        int codigo2 = tecla.getKeyCode();

	        if (codigo == tecla.VK_RIGHT) {
	            andar = false;
	            pararo = true;
	        }
	        if (codigo == tecla.VK_SPACE) {
	            soco = false;
	            pararo = true;
	            andar = false;
	        }
	        if (codigo == tecla.VK_L) {
	            soco = false;
	            pararo = true;
	            andar = false;
	            bloquear = false;
	        }
	        if (codigo == tecla.VK_DOWN) {
	            pararo = true;
	            abaixar = false;

	        }
	        if (codigo2 == tecla.VK_F) {
	            pararo = true;
	            bloquearAbaixar = false;

	        }
	        if (codigo == tecla.VK_ENTER) {
	            pararo = true;
	            apresentacao = false;

	        }

	    }


}
