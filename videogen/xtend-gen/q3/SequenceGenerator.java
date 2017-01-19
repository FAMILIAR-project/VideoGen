package q3;

import M3UPlaylist.Entry;
import M3UPlaylist.M3UPlaylistFactory;
import M3UPlaylist.Playlist;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

/**
 * Sequence generator
 */
@SuppressWarnings("all")
public class SequenceGenerator {
  private ArrayList<ArrayList<VideoDescription>> alts = new ArrayList<ArrayList<VideoDescription>>();
  
  private ArrayList<VideoDescription> opts = new ArrayList<VideoDescription>();
  
  private ArrayList<VideoDescription> md = new ArrayList<VideoDescription>();
  
  private ArrayList<String> sequence = new ArrayList<String>();
  
  private VideoGeneratorModel data;
  
  private Playlist playlist = M3UPlaylistFactory.eINSTANCE.createPlaylist();
  
  /**
   * Constructor
   */
  public SequenceGenerator(final VideoGeneratorModel data) {
    this.data = data;
    this.buildArray();
    this.buildMandatory();
    VideoDescription currentOpt = this.getAnOptional(this.opts);
    boolean _notEquals = (!Objects.equal(currentOpt, null));
    if (_notEquals) {
      String _location = currentOpt.getLocation();
      this.appendVideo(_location);
    }
    this.buildAlternative();
    for (final String file : this.sequence) {
      {
        Entry entry = M3UPlaylistFactory.eINSTANCE.createEntry();
        entry.setPath(file);
        EList<Entry> _entries = this.playlist.getEntries();
        _entries.add(entry);
      }
    }
  }
  
  /**
   * Sequence getter
   */
  public Playlist getPlaylist() {
    return this.playlist;
  }
  
  /**
   * Build alternative entries
   */
  public void buildAlternative() {
    for (final ArrayList<VideoDescription> a : this.alts) {
      {
        VideoDescription opt = this.getAnOptional(a);
        String _location = opt.getLocation();
        this.appendVideo(_location);
      }
    }
  }
  
  /**
   * Build mandatory entries
   */
  public void buildMandatory() {
    for (final VideoDescription v : this.md) {
      String _location = v.getLocation();
      this.appendVideo(_location);
    }
  }
  
  /**
   * Get optionnal sequence entries
   */
  public VideoDescription getAnOptional(final ArrayList<VideoDescription> opts) {
    ArrayList<VideoDescription> finalOpts = new ArrayList<VideoDescription>();
    for (final VideoDescription o : opts) {
      int _probability = o.getProbability();
      boolean _notEquals = (_probability != 0);
      if (_notEquals) {
        int _random = this.random(1, 100);
        int _probability_1 = o.getProbability();
        boolean _lessEqualsThan = (_random <= _probability_1);
        if (_lessEqualsThan) {
          return o;
        }
      } else {
        int _random_1 = this.random(1, 100);
        boolean _lessEqualsThan_1 = (_random_1 <= 50);
        if (_lessEqualsThan_1) {
          return o;
        }
      }
    }
    return null;
  }
  
  /**
   * Get random number from a range
   */
  public int random(final int min, final int max) {
    if ((min >= max)) {
      throw new IllegalArgumentException("max must be greater than min");
    }
    Random _random = new Random();
    int _nextInt = _random.nextInt(((max - min) + 1));
    return (_nextInt + min);
  }
  
  /**
   * Add location to the sequence
   */
  public void appendVideo(final String file) {
    this.sequence.add(file);
  }
  
  /**
   * Build usable arrays
   */
  public void buildArray() {
    EList<VideoSeq> _videoseqs = this.data.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        this.md.add(desc);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          this.opts.add(desc_1);
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          final ArrayList<VideoDescription> current = new ArrayList<VideoDescription>();
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            current.add(vdesc);
          }
          this.alts.add(current);
        }
      }
    };
    _videoseqs.forEach(_function);
  }
}
