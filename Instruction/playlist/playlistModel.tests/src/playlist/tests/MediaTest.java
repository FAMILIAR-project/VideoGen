/**
 */
package playlist.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import playlist.Media;
import playlist.PlaylistFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Media</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MediaTest extends TestCase {

	/**
	 * The fixture for this Media test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Media fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MediaTest.class);
	}

	/**
	 * Constructs a new Media test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MediaTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Media test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Media fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Media test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Media getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PlaylistFactory.eINSTANCE.createMedia());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //MediaTest
